package sistemaventas;

public class producto {

    //Trbutos
    private String nombre;
    private double precio;
    private int cantidad;

    public producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void reducirCantidad(int cantidad) {
        this.cantidad -= cantidad;
    }
}

// Clase CarritoDeCompras
class CarritoDeCompras {

    private producto[] productos;
    private int[] cantidades;
    private int numProductos;

    public CarritoDeCompras() {
        this.productos = new producto[100]; // Capacidad máxima de 100 productos en el carrito
        this.cantidades = new int[100];
        this.numProductos = 0;
    }

    public void agregarProducto(producto producto, int cantidad) {
        if (producto.getCantidad() >= cantidad) {
            productos[numProductos] = producto;
            cantidades[numProductos] = cantidad;
            numProductos++;
            System.out.println("Agregado " + cantidad + " de " + producto.getNombre() + " al carrito.");
        } else {
            System.out.println("No hay suficiente cantidad de " + producto.getNombre() + " disponible.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < numProductos; i++) {
            total += productos[i].getPrecio() * cantidades[i];
        }
        return total;
    }

    public void realizarPago(double montoPagado, double descuento) {
        double total = calcularTotal();
        double totalConDescuento = total - descuento;

        if (montoPagado >= totalConDescuento) {
            for (int i = 0; i < numProductos; i++) {
                productos[i].reducirCantidad(cantidades[i]);
            }
            double cambio = montoPagado - totalConDescuento;
            System.out.println("Pago realizado con éxito. Su cambio es: $" + cambio + ". Gracias por su compra!");
        } else {
            double cantidadFaltante = totalConDescuento - montoPagado;
            System.out.println("Pago insuficiente. Faltan $" + cantidadFaltante);
        }
    }

    public void mostrarDetalleCompra() {
        System.out.println("Detalle de la compra:");
        for (int i = 0; i < numProductos; i++) {
            System.out.println(cantidades[i] + " x " + productos[i].getNombre() + " - $" + productos[i].getPrecio() + " cada uno");
        }
    }

    @Override
    public String toString() {
        return "CarritoDeCompras{" + "productos=" + productos + ", cantidades=" + cantidades + ", numProductos=" + numProductos + '}';
    }
    
}
