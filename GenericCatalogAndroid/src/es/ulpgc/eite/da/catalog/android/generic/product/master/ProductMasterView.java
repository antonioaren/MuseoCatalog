package es.ulpgc.eite.da.catalog.android.generic.product.master;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.generic.R;
import es.ulpgc.eite.da.catalog.android.generic.pattern.master.GenericMasterView;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;

public class ProductMasterView
extends GenericMasterView implements I_ProductMasterView {

    public static final int IMAGE_DEFAULT = R.drawable.image_not_found;

    public I_ProductMasterPresenter getMasterPresenter() { //todo
        return (I_ProductMasterPresenter) getScreenPresenter();
    }

    @Override
    public int getMasterLayout() {
        return R.layout.product_master_view;
    }

    @Override
    public int getMasterList() {
        return R.id.lst_master;
    }

//    @Override
//    public int getMasterTitle() {
//        return R.string.pro_master;
//    }


    @Override
    public int getMasterRowLayout() {
        return R.layout.product_master_row;

    }

    @Override
    public void setMasterRowContent(View row, I_CatalogData data) { //todo

        TextView title = (TextView) row.findViewById(R.id.lbl_title);
        TextView subtitle = (TextView) row.findViewById(R.id.lbl_subtitle);
        ImageView image = (ImageView) row.findViewById(R.id.img_row);

        image.setImageResource(IMAGE_DEFAULT);

        ProductData _data = (ProductData) data;

        title.setText(_data.toString());
        subtitle.setText(getMasterPresenter().getMasterRowSubtitle(_data.getId()));

    }
}