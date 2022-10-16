package com.github.youssfbr.mc.entities.enums;

public enum StatePayment {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private final int id;
    private final String name;

    StatePayment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public static StatePayment toEnum(Integer id) throws IllegalAccessException {

        if (id == null) return null;

        for (StatePayment x : StatePayment.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalAccessException("Id inválido: " + id);
    }

}
