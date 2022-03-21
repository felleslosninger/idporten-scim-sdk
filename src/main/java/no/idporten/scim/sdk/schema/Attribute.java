package no.idporten.scim.sdk.schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attribute {

    public enum Mutability {
        readOnly, readWrite, immutable, writeOnly;
    }

    public enum Returned {
        always, never, request, Default;

        @JsonValue
        public String jsonValue() {
            return name().toLowerCase();
        }
    }

    public enum Uniqueness {
        none, server, global;
    }

    private String name;
    private String type;
    private boolean required;
    private Mutability mutability;
    private Returned returned;

}
