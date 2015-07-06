package es.ulpgc.eite.da.catalog.android.generic.framework;


import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.catalog.android.generic.category.detail.CategoryDetailModel;
import es.ulpgc.eite.da.catalog.android.generic.category.detail.CategoryDetailPresenter;
import es.ulpgc.eite.da.catalog.android.generic.category.detail.CategoryDetailView;
import es.ulpgc.eite.da.catalog.android.generic.category.master.CategoryMasterModel;
import es.ulpgc.eite.da.catalog.android.generic.category.master.CategoryMasterPresenter;
import es.ulpgc.eite.da.catalog.android.generic.category.master.CategoryMasterView;
import es.ulpgc.eite.da.catalog.android.generic.database.DatabaseGenericCatalog;
import es.ulpgc.eite.da.catalog.android.generic.product.detail.ProductDetailModel;
import es.ulpgc.eite.da.catalog.android.generic.product.detail.ProductDetailPresenter;
import es.ulpgc.eite.da.catalog.android.generic.product.detail.ProductDetailView;
import es.ulpgc.eite.da.catalog.android.generic.product.master.ProductMasterModel;
import es.ulpgc.eite.da.catalog.android.generic.product.master.ProductMasterPresenter;
import es.ulpgc.eite.da.catalog.android.generic.product.master.ProductMasterView;
import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.da.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.da.framework.core.mediator.MediatorTransition;

public class GenericCatalogConfig extends MediatorConfig {


    public GenericCatalogConfig(I_MediatorSingleton mediator) {
        super(mediator);
    }

    @Override
    public void setCustomConfig() {
        setCatalogConfig();
    }



    public void setCatalogConfig() {

        setCatalogTransitionCollection();
        setCatalogScreenCollection();
    }


    private void setCatalogTransitionCollection() {

//        getTransitions().add(new MediatorTransition(
//                CategoryMasterView.class, ProductMasterView.class,
//                CatalogCode.EDIT));

        getTransitions().add(new MediatorTransition(
                CategoryMasterView.class, CategoryDetailView.class,
                CatalogCode.EDIT));
        getTransitions().add(new MediatorTransition(
                CategoryMasterView.class, CategoryDetailView.class,
                CatalogCode.NEW));
        getTransitions().add(new MediatorTransition(
                CategoryDetailView.class, ProductMasterView.class,
                CatalogCode.LIST));
        getTransitions().add(new MediatorTransition(
                ProductMasterView.class, ProductDetailView.class,
                CatalogCode.NEW));
        getTransitions().add(new MediatorTransition(
                ProductMasterView.class, ProductDetailView.class,
                CatalogCode.EDIT));

    }


    private void setCatalogScreenCollection() {

        getScreens().add(new MediatorScreen(
                CategoryMasterView.class, CategoryMasterPresenter.class,
                CategoryMasterModel.class, DatabaseGenericCatalog.class));
        getScreens().add(new MediatorScreen(
                ProductMasterView.class, ProductMasterPresenter.class,
                ProductMasterModel.class, DatabaseGenericCatalog.class));

        getScreens().add(new MediatorScreen(
                CategoryDetailView.class, CategoryDetailPresenter.class,
                CategoryDetailModel.class, DatabaseGenericCatalog.class));
        getScreens().add(new MediatorScreen(
                ProductDetailView.class, ProductDetailPresenter.class,
                ProductDetailModel.class, DatabaseGenericCatalog.class));

    }


}
