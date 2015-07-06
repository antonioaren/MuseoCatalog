package es.ulpgc.eite.da.catalog.android.generic.product.detail;

import android.widget.EditText;
import android.widget.TextView;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.generic.R;
import es.ulpgc.eite.da.catalog.android.generic.pattern.detail.GenericDetailView;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;

public class ProductDetailView extends GenericDetailView implements I_ProductDetailView {

    @Override
    public int getDetailLayout() {
        return R.layout.product_detail_view;
    }

//    @Override
//    public int getDetailTitle() {
//        return R.string.pro_detail;
//    }

    public I_ProductDetailPresenter getDetailPresenter() {
        return (I_ProductDetailPresenter) getScreenPresenter();
    }

    @Override
    public I_CatalogData getDetailContent(I_CatalogData data) { //todo

        ProductData _data = (ProductData) data;

        EditText _label = (EditText) findViewById(R.id.txt_title);
        _data.setLabel(_label.getText().toString());

        return _data;
    }

    @Override
    public void setDetailContent(I_CatalogData data) {

        ProductData _data = (ProductData) data;

        debug("setDetailContent", "data", _data);

        EditText title = (EditText) findViewById(R.id.txt_title);
        title.setText(_data.toString());

        TextView subtitle = (TextView) findViewById(R.id.lbl_subtitle);
        subtitle.setText(getDetailPresenter().getDetailSubtitle());
    }

}