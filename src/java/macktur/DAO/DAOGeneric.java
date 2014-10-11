/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.DAO;

import java.util.List;

/**
 *
 * @author caioboratto
 */
public interface DAOGeneric<E> {

    public void insert(E e);

    public void update(E e);

    public void delete(E e);

    public List<E> select();

}
