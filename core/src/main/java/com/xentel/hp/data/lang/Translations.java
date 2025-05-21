package com.xentel.hp.data.lang;

import com.xentel.hp.HospitalParadox;
import com.xentel.hp.data.lang.list.EnglishTranslation;
import com.xentel.hp.data.lang.list.RussianTranslation;

public class Translations {

    public static Translation en, ru;

    public static void init() {
        en = new EnglishTranslation();
        ru = new RussianTranslation();
    }

    public static Translation getLanguageByCode(String code) {
        if (code == "ru") {
            return ru;
        }
        return en;
    }

    public static String get(String name) {
        return HospitalParadox.translation.all.get(name);
    }
}
