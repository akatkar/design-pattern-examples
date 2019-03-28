package creational.builder.form2;

public class FormBuilderTestDrive {

    public static void main(String[] args) {
        Form form = Form.formBuilder("Dave", "Carter", "DavCarter", "DAvCaEr123")
                .passwordHint("MyName")
                .city("NY")
                .language("English")
                .build();
        
        System.out.println(form);


        form = Form.formBuilder("Dave", "Carter", "DavCarter", "DAvCaEr123")
                .passwordHint("MyName")
                .city("NY")
                .backupEmail("ali@test.com")
                .language("English")
                .build();
        
        System.out.println(form);

    }
}
