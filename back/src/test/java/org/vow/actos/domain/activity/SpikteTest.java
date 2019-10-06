package org.vow.actos.domain.activity;

import com.google.schemaorg.JsonLdSerializer;
import com.google.schemaorg.JsonLdSyntaxException;
import com.google.schemaorg.core.*;
import org.junit.Test;


public class SpikteTest {
    @Test
    public void name() throws JsonLdSyntaxException {
        JsonLdSerializer serializer = new JsonLdSerializer(true /* setPrettyPrinting */);

        Thing aThing = CoreFactory.newThingBuilder().build();

        AboutPage aboutPage = CoreFactory.newAboutPageBuilder()
                .addMainEntity(aThing)
                .build();

        System.out.println(serializer.serialize(aboutPage));
    }

    @Test
    public void product() throws JsonLdSyntaxException {
        JsonLdSerializer serializer = new JsonLdSerializer(true /* setPrettyPrinting */);

        Brand brand = CoreFactory.newBrandBuilder()
                .addName("Nestlé")
                .build();
        Product product = CoreFactory.newProductBuilder()
                .addBrand(brand)
                .build();

        System.out.println(serializer.serialize(product));
    }
}