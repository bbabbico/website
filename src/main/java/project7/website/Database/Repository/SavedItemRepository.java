package project7.website.Database.Repository;

import org.springframework.stereotype.Repository;
import project7.website.Database.member.SavedItem;
import java.util.ArrayList;

public class SavedItemRepository {
    private final ArrayList<SavedItem> SavedItemList = new ArrayList<>();

    public void addSavedItemList(SavedItem savedItem) {
        SavedItemList.add(savedItem);
    }
    public ArrayList<SavedItem> getList() {
        return SavedItemList;
    }
}
