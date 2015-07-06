package es.ulpgc.eite.da.catalog.android.generic.category.master;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.generic.R;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.pattern.master.GenericMasterView;


public class CategoryMasterView
extends GenericMasterView implements I_CategoryMasterView{

    public static final int IMAGE_DEFAULT = R.drawable.image_not_found;


    public I_CategoryMasterPresenter getMasterPresenter() { //todo
        return (I_CategoryMasterPresenter) getScreenPresenter();
    }

    @Override
    public int getMasterLayout() {
        return R.layout.category_master_view;
    }

    @Override
    public int getMasterList() {
        return R.id.lst_master;
    }

//    @Override
//    public int getMasterTitle() {
//        return R.string.cat_master;
//    }


    @Override
    public int getMasterRowLayout() {
        return R.layout.category_master_row;

    }


    @Override
    public void setMasterRowContent(View row, I_CatalogData data) {

        TextView title = (TextView) row.findViewById(R.id.lbl_title);
        TextView subtitle = (TextView) row.findViewById(R.id.lbl_subtitle);
        ImageView image = (ImageView) row.findViewById(R.id.img_row);

        image.setImageResource(IMAGE_DEFAULT);

        CategoryData _data = (CategoryData) data;

        title.setText(_data.toString());
        subtitle.setText(getMasterPresenter().getMasterRowSubtitle(
                _data.getId()) + " products");
    }

}
