package dio.singleton;

/* @see <a href="https://stackoverflow.com/a/24018148">Referencia</a>
 * 
 */

public class SingletonLazyHolder {
    private static class InstanceHolder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
    }

    public static SingletonLazyHolder getInstancia() {
        return InstanceHolder.instancia;
    }
}
