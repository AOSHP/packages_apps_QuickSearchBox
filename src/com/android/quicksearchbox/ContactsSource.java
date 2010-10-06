/*
 * Copyright (C) 2010 The Android Open Source Project
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

import com.android.quicksearchbox.ui.ContactSuggestionView;
import com.android.quicksearchbox.ui.SuggestionViewFactory;
import com.android.quicksearchbox.ui.SuggestionViewInflater;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * Special case SearchableSource for contacts to provide the custom contacts suggestion view.
 */
public class ContactsSource extends SearchableSource {

    public ContactsSource(Context context, SearchableInfo searchable) throws NameNotFoundException {
        super(context, searchable);
    }

    @Override
    public SuggestionViewFactory createSuggestionViewFactory() {
        return new SuggestionViewInflater(ContactSuggestionView.VIEW_ID,
                ContactSuggestionView.class, R.layout.contact_suggestion, getContext());
    }

}