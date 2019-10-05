package main.java;

public class LocalUser extends User {

    private String ciSeries;

    private int ciNumber;

    public String getCiSeries() {
        return ciSeries;
    }

    public void setCiSeries(String ciSeries) {
        this.ciSeries = ciSeries;
    }

    public int getCiNumber() {
        return ciNumber;
    }

    public void setCiNumber(int ciNumber) {
        this.ciNumber = ciNumber;
    }

    @Override
    public String getDocument() {
        return ciSeries + ciNumber;
    }

    public void setDocument(String doc) throws InvalidDocumentException {
        System.out.println("Valid document " + doc);
        if (isInvalid(doc)) {
            throw new InvalidDocumentException("Document is not valid" + doc);
        }
        ciSeries = doc.substring(0, 2);
        ciNumber = Integer.parseInt(doc.substring(2, doc.length()));
    }

    boolean isInvalid(String doc) {
        return !checkLength(doc) || !checkSeries(doc) || !checkValue(doc);
    }

    boolean checkLength(String doc) {
        return doc.length() == 8;
    }

    boolean checkSeries(String doc) {
        return Character.isAlphabetic(doc.charAt(0)) && Character.isAlphabetic(doc.charAt(1));
    }

    boolean checkValue(String doc) {
        try{
            Integer.parseInt(doc.substring(2, doc.length()));
            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public String toString() {
        return "LocalUser{" +
                "ciSeries='" + ciSeries + '\'' +
                ", ciNumber=" + ciNumber +
                '}';
    }
}
