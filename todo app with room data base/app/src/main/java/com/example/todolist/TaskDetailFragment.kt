package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolist.databinding.FragmentTaskDetailBinding

class TaskDetailFragment : Fragment() {

    lateinit var binding:FragmentTaskDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskName = arguments?.getString("taskName") ?: ""
        val taskDesc = arguments?.getString("taskDesc") ?: ""

        binding.taskNameTextView.text = taskName
        binding.taskDescTextView.text = taskDesc
    }

    companion object {
        fun newInstance(taskName: String, taskDesc: String): TaskDetailFragment {
            val fragment = TaskDetailFragment()
            val args = Bundle()
            args.putString("taskName", taskName)
            args.putString("taskDesc", taskDesc)
            fragment.arguments = args
            return fragment
        }
    }
}
