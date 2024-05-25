package sistemaventas;

// Clase Principal para probar la funcionalidad
public class Tienda {
    public static void main(String[] args) {
        // Crear productos
        producto producto1 = new producto("Manzanas", 1.5, 100);
        producto producto2 = new producto("Naranjas", 2.0, 50);
        producto producto3 = new producto("Plátanos", 1.0, 30);

        // Crear carrito de compras
        CarritoDeCompras carrito = new CarritoDeCompras();

        // Agregar productos al carrito
        carrito.agregarProducto(producto1, 10);
        carrito.agregarProducto(producto2, 5);
        carrito.agregarProducto(producto3, 20);

        // Mostrar detalle de la compra
        carrito.mostrarDetalleCompra();

        // Calcular total y realizar pago
        double total = carrito.calcularTotal();
        System.out.println("Total de la compra: $" + total);

        // Verificar y aplicar descuento si el total supera $1000
        double descuento = 0;
        if (total > 1000) {
            descuento = total * 0.1; // 10% de descuento
            System.out.println("Se aplicará un descuento de $" + descuento);
        }

        // Realizar pago
        carrito.realizarPago(1000, descuento);
    }
}