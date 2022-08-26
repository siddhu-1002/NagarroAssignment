package com.insurancePremiumCalculation;

public class calculateInsurance {

    private String model;
    private String type;
    private int price;
    private String insuranceType;

    //    private String[] carTypes = {"Hatchback", "Sedan", "SUV"};
    private float[] insuranceAmount = {0.05F, 0.08F, 0.10F};
    private String[] insuranceTypes = {"Basic", "Premium"};

    public calculateInsurance(String model, String type, int price,
                              String insuranceType) {
        this.model = model;
        this.type = type;
        this.price = price;
        this.insuranceType = insuranceType;
    }

    // Getters and Setters to access the data or modify it
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInsuranceType() {
        return this.insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }


    protected int calculateInsuranceAmount() {

        int amount = 0;

        if (insuranceType.equals("Basic")) {
            switch (type) {
                case "Hatchback":
                    amount += (price * insuranceAmount[0]);
                    break;
                case "Sedan":
                    amount += (price * insuranceAmount[1]);
                    break;
                case "Suv":
                    amount += (price * insuranceAmount[2]);
                    break;

            }
        }

        else if (insuranceType.equals("Premium")){
            amount += (price * 0.2);
            }

        return price + amount;
    }
}
