package es.ulpgc.eite.da.catalog.android.generic.category.data;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name="catalog_category")
public class CategoryData implements I_CatalogData {


    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    private Long id;

    @Column(name = "label")
    private String label;


    public CategoryData() {
        setLabel("");
        setId(0L);
    }

    public CategoryData(String label) {
        setLabel(label);
        setId(0L);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String text) {
        label = text;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long dataId) {
        id = dataId;
    }


    @Override
    public boolean equals(Object obj) {

        if(obj instanceof CategoryData) {
            CategoryData data = (CategoryData) obj;

            if(data.getId() == getId()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return getLabel();
    }


}
