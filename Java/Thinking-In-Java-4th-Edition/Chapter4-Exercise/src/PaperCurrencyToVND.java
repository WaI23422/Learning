public enum PaperCurrencyToVND {
    Dollar(24380f),
    Won(18.23f),
    Krone(2195.63f),
    Franc(9.85f),
    Euro(25935.57f),
    Pound(29839.41f);

    private float value;

    PaperCurrencyToVND(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
