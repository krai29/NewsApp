package com.krai29.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.krai29.newsapp.util.Resource
import com.krai29.newsapp.R
import com.krai29.newsapp.ui.activity.NewsActivity
import com.krai29.newsapp.ui.adapter.NewsAdapter
import com.krai29.newsapp.ui.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment() {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_breaking_news,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setUpRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
           when(response){
               is Resource.Success -> {
                   hideProgressBar()
                   response.data?.let { newsResponse ->
                      newsAdapter.differ.submitList(newsResponse.articles)
                   }
               }
               is Resource.Error -> {
                   hideProgressBar()
                   response.message?.let { message ->
                     Toast.makeText(activity,message,Toast.LENGTH_LONG).show()
                   }
               }
               is Resource.Loading -> {
                   showProgressBar()
               }
           }
        })
    }

    private fun setUpRecyclerView() {
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar(){
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
    }
}