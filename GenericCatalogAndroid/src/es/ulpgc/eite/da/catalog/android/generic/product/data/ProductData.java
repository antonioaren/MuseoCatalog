package es.ulpgc.eite.da.catalog.android.generic.product.data;


import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.ForeignKey;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name="catalog_product")
public class ProductData implements I_ProductData {


    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    private Long id;

    @Column(name = "label")
    private String label;

    @ForeignKey(tableReference="catalog_category",
                onDeleteCascade=true, columnReference="id")
    @Column(name = "parent_id")
    private Long parentId;


    public ProductData() {
        setLabel("");
        setId(0L);
        setParentId(0L);
    }


    public ProductData(String label) {
        setLabel(label);
        setId(0L);
        setParentId(0L);
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
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long dataId) {
        parentId = dataId;
    }


    @Override
    public boolean equals(Object obj) {

        if(obj instanceof ProductData) {
            ProductData data = (ProductData) obj;

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
