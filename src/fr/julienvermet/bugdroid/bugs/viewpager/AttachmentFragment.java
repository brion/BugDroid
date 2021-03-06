package fr.julienvermet.bugdroid.bugs.viewpager;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import fr.julienvermet.bugdroid.R;
import fr.julienvermet.bugdroid.database.Attachment;

public class AttachmentFragment extends Fragment {

	ArrayList<Attachment> attachments;

	public static AttachmentFragment newInstance(ArrayList<Attachment> attachments) {
		Log.i("Pager", "TestFragment.newInstance()");

		AttachmentFragment fragment = new AttachmentFragment();

		Bundle args = new Bundle();
		args.putSerializable("attachments", attachments);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.attachments = (ArrayList<Attachment>) getArguments().getSerializable("attachments");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.i("Pager", "AttachmentFragment.onCreateView()");

		if (attachments != null)
		{
			LinearLayout llAttachments = (LinearLayout) inflater.inflate(R.layout.attachments, null);

			ListView lvAttachments = (ListView) llAttachments.findViewById(R.id.lvAttachments);

			lvAttachments.setAdapter(new AttachmentListAdapter(attachments, getActivity()));

			return llAttachments;
		}
		else
		{
			TextView tv = new TextView(getActivity());
			tv.setText("No attachment");
			return tv;
		}
	}
}