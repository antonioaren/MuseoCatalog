package es.ulpgc.eite.da.catalog.android.generic.pattern.master;


import android.view.View;
import android.widget.Button;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.catalog.android.core.master.MasterView;
import es.ulpgc.eite.da.catalog.android.generic.R;

public abstract class GenericMasterView
extends MasterView implements I_GenericMasterView {

    @Override
    public void initMaster() {
        super.initMaster();

        setMasterButtons();
    }

    private void setMasterButtons() {

        Button _new = (Button) findViewById(R.id.btn_new);
        Button _clear = (Button) findViewById(R.id.btn_clear);

        _clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onMasterButtonClick(CatalogCode.CLEAR);
            }
        });

        _new.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onMasterButtonClick(CatalogCode.NEW);
            }
        });
    }



    @Override
    public void updateMasterButton(boolean status) {
        Button _clear = (Button) findViewById(R.id.btn_clear);

        _clear.setEnabled(status);
    }



}
