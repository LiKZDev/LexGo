package dev.likz.lawnetgo.entities;

import android.os.Parcel;

public class SearchSuggestion implements com.arlib.floatingsearchview.suggestions.model.SearchSuggestion {

    private String searchName;
    private String description;

    public SearchSuggestion() {

    }

    public SearchSuggestion(String searchName) {
        this.searchName = searchName;
    }

    public SearchSuggestion(Parcel source) {
        this.searchName = source.readString();
        this.description = source.readString();
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getBody() {
        return searchName;
    }

    public static final Creator<SearchSuggestion> CREATOR = new Creator<SearchSuggestion>() {
        @Override
        public SearchSuggestion createFromParcel(Parcel in) {
            return new SearchSuggestion(in);
        }

        @Override
        public SearchSuggestion[] newArray(int size) {
            return new SearchSuggestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(searchName);
        dest.writeString(description);
    }
}
