package integration;

import model.Currency;

import javax.persistence.*;

/**
 * Provides access to persistent storage.
 */
public class CurrencyDAO {

    private final EntityManagerFactory factory;

    private EntityManager manager;
    private EntityTransaction transaction;

    public CurrencyDAO() {
        factory = Persistence.createEntityManagerFactory("currency");
    }

    /**
     * Save the currency to persistent storage.
     * @param currency Currency to be stored.
     */
    public void save(Currency currency) {
        startTransaction();
        manager.persist(currency);
        endTransaction();
    }

    /**
     * Find a currency by name in persistent storage.
     * @param name Name of the currency.
     */
    public Currency findByName(String name) {
        openNewManager();
        Query query = manager.createNamedQuery(Currency.FIND_BY_NAME_QUERY)
                .setParameter("name", name);
        Currency currency = (Currency)query.getSingleResult();
        closeManager();
        return  currency;
    }

    private void startTransaction() {
        openNewManager();
        transaction = manager.getTransaction();
        transaction.begin();
    }

    private void endTransaction() {
        transaction.commit();
        closeManager();
    }

    private void openNewManager() {
        manager = factory.createEntityManager();
    }

    private void closeManager() {
        manager.close();
    }
}
