package com.krai29.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.krai29.newsapp.R
import com.krai29.newsapp.ui.activity.NewsActivity
import com.krai29.newsapp.ui.viewmodel.NewsViewModel

class SearchNewsFragment : Fragment(R.layout.fragment_search_news){

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }

}

