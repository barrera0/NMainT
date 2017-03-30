package com.NMainT.controlador;

import com.NMainT.modelo.entities.Detallemttos;
import com.NMainT.controlador.util.JsfUtil;
import com.NMainT.controlador.util.PaginationHelper;
import com.NMainT.modelo.facades.DetallemttosFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("detallemttosController")
@SessionScoped
public class DetallemttosController implements Serializable {

    private Detallemttos current;
    private DataModel items = null;
    @EJB
    private com.NMainT.modelo.facades.DetallemttosFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public DetallemttosController() {
    }

    public Detallemttos getSelected() {
        if (current == null) {
            current = new Detallemttos();
            current.setDetallemttosPK(new com.NMainT.modelo.entities.DetallemttosPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private DetallemttosFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Detallemttos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Detallemttos();
        current.setDetallemttosPK(new com.NMainT.modelo.entities.DetallemttosPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getDetallemttosPK().setIdMtto(current.getMantenimientos().getIdMtto());
            current.getDetallemttosPK().setIdEquipo(current.getEquipos().getIdEquipo());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallemttosCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Detallemttos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getDetallemttosPK().setIdMtto(current.getMantenimientos().getIdMtto());
            current.getDetallemttosPK().setIdEquipo(current.getEquipos().getIdEquipo());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallemttosUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Detallemttos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DetallemttosDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Detallemttos getDetallemttos(com.NMainT.modelo.entities.DetallemttosPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Detallemttos.class)
    public static class DetallemttosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetallemttosController controller = (DetallemttosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detallemttosController");
            return controller.getDetallemttos(getKey(value));
        }

        com.NMainT.modelo.entities.DetallemttosPK getKey(String value) {
            com.NMainT.modelo.entities.DetallemttosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.NMainT.modelo.entities.DetallemttosPK();
            key.setIdEquipo(Integer.parseInt(values[0]));
            key.setIdMtto(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.NMainT.modelo.entities.DetallemttosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEquipo());
            sb.append(SEPARATOR);
            sb.append(value.getIdMtto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Detallemttos) {
                Detallemttos o = (Detallemttos) object;
                return getStringKey(o.getDetallemttosPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Detallemttos.class.getName());
            }
        }

    }

}
