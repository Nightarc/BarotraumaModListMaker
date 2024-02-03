package app;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

//Вход: ссылка на колекцию
//Выход: список имен и айдишников модов из коллекции
//Оформить xml файл в формате мод листа совместимого с баротравмой
public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java -jar <file-name>.jar <steamCollectionURL>");
            return;
        }

        String collectionURL = args[0];

        Document collectionPage;
        try {
            collectionPage = Jsoup.connect(collectionURL).get();
        }
        catch(IOException exception) {
            System.err.println("Invalid collection URL!");
            return;
        }

        ModList modList;
        try {
            Elements modsList = collectionPage.getElementsByClass("collectionItem");
            modList = new ModList(
                    Objects.requireNonNull(
                    collectionPage.
                    getElementsByClass("workshopItemTitle").first()).text()
            );

            for (Element mod : modsList) {
                String id = mod.attr("id");
                id = id.substring(11); // remove the "sharedfile_" part
                WorkshopItem workshopItem = new WorkshopItem(
                        Objects.requireNonNull(
                                mod.select("div:nth-child(2) > a:nth-child(1) > div:nth-child(1)").first())
                                .text(), id);
                modList.mods.add(workshopItem);
            }
        }
        catch(NullPointerException exception) {
            System.err.println("Error has occured while parsing a collection from Steam");
            return;
        }

        try {
            JAXBContext context = JAXBContext.newInstance(ModList.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(modList, new File("./" + modList.getName().replace("/", "") + ".xml"));
        } catch(JAXBException exception) {
            System.err.println("An error occured while trying to marshal XML file.");
        }
    }
}