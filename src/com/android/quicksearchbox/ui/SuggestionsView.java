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

package com.android.quicksearchbox.ui;

import com.android.quicksearchbox.SuggestionPosition;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Holds a list of suggestions.
 */
public class SuggestionsView extends ListView {

    private static final boolean DBG = false;
    private static final String TAG = "QSB.SuggestionsView";

    private SuggestionClickListener mSuggestionClickListener;

    public SuggestionsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        setOnItemClickListener(new ItemClickListener());
        setOnItemLongClickListener(new ItemLongClickListener());
    }

    public void setSuggestionClickListener(SuggestionClickListener listener) {
        mSuggestionClickListener = listener;
    }

    /**
     * Gets the position of the selected suggestion.
     *
     * @return A 0-based index, or {@code -1} if no suggestion is selected.
     */
    public int getSelectedPosition() {
        return getSelectedItemPosition();
    }

    /**
     * Gets the selected suggestion.
     *
     * @return {@code null} if no suggestion is selected.
     */
    public SuggestionPosition getSelectedSuggestion() {
        return (SuggestionPosition) getSelectedItem();
    }

    private class ItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (DBG) Log.d(TAG, "onItemClick(" + position + ")");
            if (mSuggestionClickListener != null) {
                mSuggestionClickListener.onSuggestionClicked(position);
            }
        }
    }

    private class ItemLongClickListener implements AdapterView.OnItemLongClickListener {
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            if (DBG) Log.d(TAG, "onItemLongClick(" + position + ")");
            if (mSuggestionClickListener != null) {
                return mSuggestionClickListener.onSuggestionLongClicked(position);
            }
            return false;
        }
    }

    public void onIcon2Clicked(int position) {
        if (mSuggestionClickListener != null) {
            mSuggestionClickListener.onSuggestionQueryRefineClicked(position);
        }
    }

}
