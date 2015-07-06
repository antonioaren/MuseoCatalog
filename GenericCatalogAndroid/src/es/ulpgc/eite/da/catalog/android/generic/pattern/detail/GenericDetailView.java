package es.ulpgc.eite.da.catalog.android.generic.pattern.detail;


import android.view.View;
import android.widget.Button;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailView;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.catalog.android.generic.R;

public abstract class GenericDetailView
extends DetailView implements I_GenericDetailView {

    public abstract I_GenericDetailPresenter getDetailPresenter();


    @Override
    public void initDetail() {
        super.initDetail();

        setDetailButtons();
    }

    @Override
    public void setDetailButtons() {

        Button _save = (Button) findViewById(R.id.btn_save);
        Button _add = (Button) findViewById(R.id.btn_add);
        Button _del = (Button) findViewById(R.id.btn_del);
        Button _prev = (Button) findViewById(R.id.btn_prev);
        Button _next = (Button) findViewById(R.id.btn_next);

        _save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onDetailButtonClick(CatalogCode.SAVE);
            }
        });

        _add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onDetailButtonClick(CatalogCode.ADD);
            }
        });

        _del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onDetailButtonClick(CatalogCode.DEL);
            }
        });

        _next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onDetailButtonClick(CatalogCode.NEXT);
            }
        });

        _prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onDetailButtonClick(CatalogCode.PREV);
            }
        });

    }

    public void onDetailButtonClick(int code) {
        getDetailPresenter().onDetailButtonClick(code);
    }


    @Override
    public boolean updateDetailButtons(int code) { //todo

        Button _add = (Button) findViewById(R.id.btn_add);
        Button _del = (Button) findViewById(R.id.btn_del);
        Button _prev = (Button) findViewById(R.id.btn_prev);
        Button _next = (Button) findViewById(R.id.btn_next);

        boolean status = true;

        if (code == CatalogCode.NEW || code == CatalogCode.ADD) {
            status = false;

        }

        _next.setEnabled(status);
        _prev.setEnabled(status);
        _add.setEnabled(status);
        _del.setEnabled(status);

        return status;

    }

    @Override
    public void updateDetailButtons(int code, boolean status) {

        Button _prev = (Button) findViewById(R.id.btn_prev);
        Button _next = (Button) findViewById(R.id.btn_next);

        if(code == CatalogCode.NEXT) {
            _next.setEnabled(status);
        }
        if(code == CatalogCode.PREV) {
            _prev.setEnabled(status);
        }

    }

}
