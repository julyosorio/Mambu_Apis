package co.com.bancopichincha.mambu.utils;


import co.com.bancopichincha.mambu.models.create.CreateCustomer;
import co.com.bancopichincha.mambu.models.loantransaction.BodySearchLoan;
import co.com.bancopichincha.mambu.models.loantransaction.FilterCritter;

import co.com.bancopichincha.mambu.models.search.DataFilter;
import co.com.bancopichincha.mambu.models.search.FilterCriterium;
import co.com.bancopichincha.mambu.models.search.SortingCriteria;
import co.com.bancopichincha.mambu.models.update.Address;
import co.com.bancopichincha.mambu.models.update.ClientsUpdate;
import co.com.bancopichincha.mambu.models.update.Personalizados;
import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataManager {

    private DataManager() {
        throw new IllegalStateException("Utility class");
    }

    public static BodySearchLoan bodySearchLoanId(String value) {
        FilterCritter filterCritter = FilterCritter.builder()
                .field("id")
                .operator("EQUALS")
                .value(value)
                .build();
        List<FilterCritter> filterArrayList = new ArrayList<>();
        filterArrayList.add(filterCritter);
        return BodySearchLoan.builder()
                .filterCriteria(filterArrayList)
                .build();
    }

    public static ClientsUpdate loadBodyUpdateUser() {
        ArrayList<Address> address = new ArrayList<>();
        Personalizados personalizado = new Personalizados("7ae9c905-21da-4efd-9168-b9b14feb070b");
        address.add(Address.builder()
                .city("Medellín")
                .country("Colombia")
                .indexInList(0)
                .latitude(0)
                .line1("te")
                .line2("u")
                .longitude(0)
                .postcode("100011")
                .region("Antioquia")
                .build());
        return ClientsUpdate.builder()
                .id("119486899")
                .encodedKey("8a44c3d386edc3a70186efd8302621e4")
                .personalizados(personalizado)
                .firstName("Karen")
                .lastName("Mendoza")
                .state("INACTIVE")
                .gender("FEMALE")
                .preferredLanguage("spanish")
                .addresses(address)
                .build();
    }

    public static DataFilter loadFilterSearchBody(String field, String value) {
        SortingCriteria sortingCriteria = SortingCriteria.builder()
                .field("encodedKey")
                .order("ASC")
                .build();
        FilterCriterium filterCriterium = FilterCriterium.builder()
                .field(field)
                .operator("EQUALS")
                .secondValue(null)
                .value(value)
                .values(null)
                .build();
        List<FilterCriterium> arreglo = new ArrayList<>();
        arreglo.add(filterCriterium);
        return DataFilter.builder()
                .sortingCriteria(sortingCriteria)
                .filterCriteria(arreglo)
                .build();

    }

    public static CreateCustomer loadBodyCreateUser() {
        ArrayList<Address> address = new ArrayList<>();
        Faker faker = new Faker(new Locale("es", "CO"));
        String gender = faker.options().option("male", "female");
        Personalizados personalizado = new Personalizados(faker.number().digits(10));

        address.add(Address.builder()
                .city(faker.address().city())
                .country(faker.address().country())
                .indexInList(0)
                .latitude(0)
                .line1("te")
                .line2("u")
                .longitude(0)
                .postcode(faker.address().zipCode())
                .region(faker.address().state())
                .build());
        return CreateCustomer.builder()
                .state("INACTIVE")
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .preferredLanguage("spanish")
                .gender(gender)
                .loanCycle(0)
                .groupLoanCycle(0)
                .personalizados(personalizado)
                .addresses(address)
                .build();
    }
}
