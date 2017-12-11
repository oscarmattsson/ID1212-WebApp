package model;

import org.eclipse.persistence.annotations.PrimaryKey;
import org.eclipse.persistence.nosql.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@NamedQueries(
        @NamedQuery(
                name = Currency.FIND_BY_NAME_QUERY,
                query = "SELECT c FROM Currency c WHERE c.name=:name"
        )
)

@Entity
@NoSql(dataFormat= DataFormatType.MAPPED)
public class Currency implements Serializable {

    public static final String FIND_BY_NAME_QUERY = "findByName";

    @Id
    @PrimaryKey
    private String name;
    private double rate;

    public Currency() {
        super();
    }

    public Currency(String name, double rate) {
        super();
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
