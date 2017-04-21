package mizu;

import mizu.rest.ProductFacadeREST;

/**
 * Created by ms.rodriguez on 21/4/2017.
 */
public class Main {
    public static void main (String[] args) {
        ProductFacadeREST facade = new ProductFacadeREST();

        facade.delete("sailor_moon_wig");
    }
}
