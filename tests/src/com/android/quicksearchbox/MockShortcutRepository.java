/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.quicksearchbox;

import android.content.ComponentName;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock implementation of {@link ShortcutRepository}.
 *
 */
public class MockShortcutRepository implements ShortcutRepository {

    public void clearHistory() {
    }

    public void close() {
    }

    public SuggestionCursor getShortcutsForQuery(String query) {
        DataSuggestionCursor cursor = new DataSuggestionCursor(query);
        SuggestionData s1 = new SuggestionData.Builder(MockSource.SOURCE_1)
                .text1(query + "_1_shortcut")
                .displayQuery(query + "_1_shortcut")
                .build();
        SuggestionData s2 = new SuggestionData.Builder(MockSource.SOURCE_2)
                .text1(query + "_2_shortcut")
                .displayQuery(query + "_2_shortcut")
                .build();
        cursor.add(s1);
        cursor.add(s2);
        return cursor;
    }

    public ArrayList<ComponentName> getSourceRanking() {
        return null;
    }

    public boolean hasHistory() {
        return false;
    }

    public void refreshShortcut(ComponentName source, String shortcutId,
            SuggestionPosition refreshed) {
    }

    public void reportClick(SuggestionPosition clicked) {
    }

    public void reportImpressions(List<SuggestionPosition> impressions) {
    }

}