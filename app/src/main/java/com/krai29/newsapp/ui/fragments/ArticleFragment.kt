package com.krai29.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.krai29.newsapp.R
import com.krai29.newsapp.ui.activity.NewsActivity
import com.krai29.newsapp.ui.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    val args : ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article saved successfully",Snackbar.LENGTH_LONG)
                .show()
        }
    }
}