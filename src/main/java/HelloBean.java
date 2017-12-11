import integration.CurrencyDAO;
import model.Currency;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="hello", eager=true)
public class HelloBean {

    public HelloBean() {

    }

    public String getMessage() {
        return "Hello, world!";
    }
}