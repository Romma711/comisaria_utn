import Almacen.*;
import Enums.*;
import Area.*;

public class Main {
    public static void main(String[] args) {
        Almacen cochera = new Almacen();

        Evidencia arma = new Evidencia(T_Material.ARMA, "A5", "Huellas");
        Evidencia muesta = new Evidencia(T_Material.MUESTRA, "A5-Arma", "Sangre");
        Evidencia muesta2 = new Evidencia(T_Material.MUESTRA, "D4", "Orina");
        Evidencia escritura = new Evidencia(T_Material.ESCRITURA, "M2", "Grafología");
        Caso asesinato = new Caso("Andres Roma brutalmente apuñalado.","Cantó Simphony");
        asesinato.agregarEvidencia(arma);
        asesinato.agregarEvidencia(muesta);
        asesinato.agregarEvidencia(muesta2);
        asesinato.agregarEvidencia(escritura);
        cochera.agregarAlAlmacen(T_Registro.CASO, asesinato);

        Evidencia arma2 = new Evidencia(T_Material.ARMA, "I5", "Deditos");
        Evidencia muesta5 = new Evidencia(T_Material.MUESTRA, "I5-Arma", "Choclo");
        Evidencia muesta3 = new Evidencia(T_Material.MUESTRA, "D4", "Picada");
        Evidencia escritura4 = new Evidencia(T_Material.ESCRITURA, "M2", "Pedido de auxilio con sangre");
        Caso asesinato2 = new Caso("Lisandro Devoto? apuñalado 532 veces por una tucumana.","Dijo feminazi a una vtuber");
        asesinato2.agregarEvidencia(arma2);
        asesinato2.agregarEvidencia(muesta5);
        asesinato2.agregarEvidencia(muesta3);
        asesinato2.agregarEvidencia(escritura4);
        cochera.agregarAlAlmacen(T_Registro.CASO, asesinato2);

        Material_Policial chumbo = new Material_Policial("534651", T_Material.ARMA);
        Material_Policial esposas = new Material_Policial("5475681", T_Material.ESPOSAS);
        Material_Policial investigacion = new Material_Policial("987654", T_Material.ESCRITURA);
        cochera.agregarAlAlmacen(T_Registro.MATERIAL_POLICIAL, chumbo);
        cochera.agregarAlAlmacen(T_Registro.MATERIAL_POLICIAL, esposas);
        cochera.agregarAlAlmacen(T_Registro.MATERIAL_POLICIAL, investigacion);

        Denuncia denuncia2 = new Denuncia("42590901", "41928141", "Me dijo mogolico");
        cochera.agregarAlAlmacen(T_Registro.DENUNCIAS, denuncia2);

        Denuncia denuncia3 = new Denuncia("41928141", "42590901", "Ve demasiado One Piece");
        cochera.agregarAlAlmacen(T_Registro.DENUNCIAS, denuncia3);

        Comisaria.menuPrincipal();
    }
}