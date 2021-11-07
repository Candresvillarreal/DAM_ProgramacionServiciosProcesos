# DAM_ProgramacionServiciosProcesos

Clase PrecioProducto -> clase que crea objetos que contienen proveedor y precio para un producto.  Contiene sus métodos get y set y sobreescribo el método toString 
                        para mostrar el contenido.
Clase Semaforo -> clase que implementa un semáforo binario que incluye dos métodos, uno para cada posición del semáforo.  En una posición permitirá que se inserten 
                  datos en el array PrecioProducto y en la otra posición indicará que no está disponible.                       
Clase InsertaPrecio -> clase que inserta en un array de 10 posiciones y de tipo PrecioProducto los diferentes proveedores y el precio de cada proveedor. 
                        Ejecutará el método inserta() de la clase Semaforo
Clase ArrayOcupado -> clase que indica que el array de tipo PrecioProducto está ocupado y, por tanto, no puede ser utilizado.
                        Ejecutará el método ocupado() de la clase Semaforo
Clase Principal -> ejecuta las clases InsertaPrecio y ArrayOcupado creando un Thread para cada una de ellas.  Al ejecutarse, primero se inserta un nuevo proveedor y precio 
                    al array PrecioProducto productos[] y después indica que está ocupado y se va repitiendo la secuencia hasta llenar el array (10 posiciones).
