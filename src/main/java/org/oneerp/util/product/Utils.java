package org.oneerp.util.product;

import lombok.Getter;

public class Utils {

    @Getter
    public enum Measurement{
        GRAM("gram"),
        GRAMS("grams"),
        KG("Kg"),
        KGS("Kgs"),
        ML("ml"),
        MLS("mls"),
        LITER("liter"),
        LITERS("liters"),
        UNIT("Unit"),
        UNITS("Units");

        private final String value;

        Measurement(String value) {
            this.value = value;
        }
    }
}
