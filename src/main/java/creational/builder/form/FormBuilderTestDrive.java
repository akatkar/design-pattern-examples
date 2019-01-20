package creational.builder.form;

public class FormBuilderTestDrive {

    public static void main(String[] args) {
        Form form = new Form.FormBuilder("Dave", "Carter", "DavCarter", "DAvCaEr123")
                .passwordHint("MyName")
                .city("NY")
                .language("English")
                .build();
        
        System.out.println(form);
    }
}
