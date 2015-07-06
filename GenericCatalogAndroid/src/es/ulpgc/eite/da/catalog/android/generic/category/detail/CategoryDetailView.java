package es.ulpgc.eite.da.catalog.android.generic.category.detail;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.catalog.android.generic.R;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.pattern.detail.GenericDetailView;

public class CategoryDetailView extends GenericDetailView implements I_CategoryDetailView {


//    @Override
//    public int getDetailTitle() {
//        return R.string.cat_detail;
//    }
    public I_CategoryDetailPresenter getDetailPresenter() {
         return (I_CategoryDetailPresenter) getScreenPresenter();
    }

    @Override
    public int getDetailLayout() {
        return R.layout.category_detail_view;
    }

    @Override
    public void setDetailButtons() {
        super.setDetailButtons();

        Button _list = (Button) findViewById(R.id.btn_list);

        _list.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                onDetailButtonClick(CatalogCode.LIST);
            }
        });
    }



    @Override
    public boolean updateDetailButtons(int code) {

        boolean status = super.updateDetailButtons(code);

        Button _list = (Button) findViewById(R.id.btn_list);

        int mCode = getDetailPresenter().getMasterCode();
        int dCode = getDetailPresenter().getDetailCode();

        boolean _status = status;

        if (dCode == CatalogCode.SAVE || mCode == CatalogCode.EDIT) {
            _status = true;
        }

        _list.setEnabled(_status);

        return status;
    }

    @Override
    public void setDetailContent(I_CatalogData _data) { //todo

        CategoryData data = (CategoryData) _data;

        debug("setDetailContent", "data", data);

        EditText title = (EditText) findViewById(R.id.txt_title);
        title.setText(data.toString());

        TextView subtitle = (TextView) findViewById(R.id.lbl_subtitle);
        subtitle.setText(getDetailPresenter().getDetailSubtitle() + " products");
    }

    @Override
    public I_CatalogData getDetailContent(I_CatalogData _data) {  //todo

        CategoryData data = (CategoryData) _data;

        EditText _label = (EditText) findViewById(R.id.txt_title);
        data.setLabel(_label.getText().toString());

        return data;
    }
}