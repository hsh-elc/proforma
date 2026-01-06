package proforma.xml21;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter to generate values conforming https://www.w3.org/TR/xmlschema-2/#decimal .
 */
public class BigDecimal18PlaceAdapter extends XmlAdapter<String, BigDecimal> {
    private static final MathContext CTX = new MathContext(18, RoundingMode.CEILING);

    @Override
    public String marshal(BigDecimal v) throws Exception {
        if (v == null) return null;
        BigDecimal rounded = v.round(CTX).stripTrailingZeros();
        return rounded.toPlainString();
    }

    @Override
    public BigDecimal unmarshal(String v) throws Exception {
        if (v == null) return null;
        return new BigDecimal(v).stripTrailingZeros();
    }

}