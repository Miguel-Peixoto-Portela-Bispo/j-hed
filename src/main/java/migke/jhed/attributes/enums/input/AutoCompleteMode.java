package migke.jhed.attributes.enums.input;

public enum AutoCompleteMode {
    OFF("off"),
    ON("on"),
    NAME("name"),
    HONORIFIC_PREFIX("honorific-prefix"),
    GIVEN_NAME("given-name"),
    ADDITIONAL_NAME("additional-name"),
    FAMILY_NAME("family-name"),
    HONORIFIC_SUFFIX("honorific-suffix"),
    NICKNAME("nickname"),
    EMAIL("email"),
    USERNAME("username"),
    NEW_PASSWORD("new-password"),
    CURRENT_PASSWORD("current-password"),
    ONE_TIME_CODE("one-time-code"),
    ORGANIZATION_TITLE("organization-title"),
    ORGANIZATION("organization"),
    STREET_ADDRESS("street-address"),
    ADDRESS_LINE1("address-line1"),
    ADDRESS_LINE2("address-line2"),
    ADDRESS_LINE3("address-line3"),
    ADDRESS_LEVEL4("address-level4"),
    ADDRESS_LEVEL3("address-level3"),
    ADDRESS_LEVEL2("address-level2"),
    ADDRESS_LEVEL1("address-level1"),
    COUNTRY("country"),
    COUNTRY_NAME("country-name"),
    POSTAL_CODE("postal-code"),
    CC_NAME("cc-name"),
    CC_GIVEN_NAME("cc-given-name"),
    CC_ADDITIONAL_NAME("cc-additional-name"),
    CC_FAMILY_NAME("cc-family-name"),
    CC_NUMBER("cc-number"),
    CC_EXPIRY("cc-expiry"),
    CC_EXPIRY_MONTH("cc-expiry-month"),
    CC_EXPIRY_YEAR("cc-expiry-year"),
    CC_CSC("cc-csc"),
    CC_TYPE("cc-type"),
    TRANSACTION_CURRENCY("transaction-currency"),
    TRANSACTION_AMOUNT("transaction-amount"),
    LANGUAGE("language"),
    BDAY("bday"),
    BDAY_DAY("bday-day"),
    BDAY_MONTH("bday-month"),
    BDAY_YEAR("bday-year"),
    SEX("sex"),
    TEL("tel"),
    TEL_COUNTRY_CODE("tel-country-code"),
    TEL_NATIONAL("tel-national"),
    TEL_AREA_CODE("tel-area-code"),
    TEL_LOCAL("tel-local"),
    TEL_LOCAL_PREFIX("tel-local-prefix"),
    TEL_LOCAL_SUFFIX("tel-local-suffix"),
    TEL_EXTENSION("tel-extension"),
    IMPP("impp"),
    URL("url"),
    PHOTO("photo");

    private final String value;

    AutoCompleteMode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}