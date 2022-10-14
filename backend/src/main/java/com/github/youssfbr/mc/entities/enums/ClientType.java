package com.github.youssfbr.mc.entities.enums;

public enum ClientType {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private final int id;
    private final String name;

    ClientType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public static ClientType toEnum(Integer id) throws IllegalAccessException {

        if (id == null) return null;

        for (ClientType x : ClientType.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalAccessException("Id inválido: " + id);
    }

}
