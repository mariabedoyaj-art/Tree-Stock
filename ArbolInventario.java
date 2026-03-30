//Se agregan comentarios al código
public class ArbolInventario {
    Producto raiz;

    public Producto insertar(Producto raiz, int id, String nombre) {
        if (raiz == null) {
            return new Producto(id, nombre);
        }

        if (id < raiz.id) {
            raiz.izquierdo = insertar(raiz.izquierdo, id, nombre);
        } else if (id > raiz.id) {
            raiz.derecho = insertar(raiz.derecho, id, nombre);
        }

        return raiz;
    }

    public void insertar(int id, String nombre) {
        raiz = insertar(raiz, id, nombre);
    }

    public void inorden(Producto raiz) {
        if (raiz != null) {
            inorden(raiz.izquierdo);
            System.out.println("ID: " + raiz.id + " - Nombre: " + raiz.nombre);
            inorden(raiz.derecho);
        }
    }

    public void mostrarInventario() {
        if (raiz == null) {
            System.out.println("Inventario vacío.");
        } else {
            inorden(raiz);
        }
    }

    public Producto buscar(Producto raiz, int id) {
        if (raiz == null || raiz.id == id) {
            return raiz;
        }

        if (id < raiz.id) {
            return buscar(raiz.izquierdo, id);
        } else {
            return buscar(raiz.derecho, id);
        }
    }

    public void buscar(int id) {
        Producto resultado = buscar(raiz, id);

        if (resultado != null) {
            System.out.println("Producto encontrado: " + resultado.nombre);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
