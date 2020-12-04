package cl.sebastian.telefonos.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import cl.sebastian.telefonos.databinding.FragmentDetailBinding;
import cl.sebastian.telefonos.model.DetalleProducto;
import cl.sebastian.telefonos.viewmodel.TelefonosViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private static final String TAG = "DetailFragment";
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private TelefonosViewModel viewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentDetailBinding binding;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(TelefonosViewModel.class);
        viewModel.loadDetail(Integer.parseInt(mParam2));

        // predicado: nombreVariable -> acción
        viewModel.getDetalleProducto().observe(getViewLifecycleOwner(), productDetail -> showDetail(productDetail));

        return binding.getRoot();
    }

    private void showDetail(DetalleProducto productDetail) {
        binding.tvDetailName.setText(productDetail.getName());
        binding.tvDetailDescription.setText(productDetail.getDescription());
        binding.tvDetailPrice.setText(String.valueOf(productDetail.getPrice()));
        binding.tvDetailLastPrice.setText(String.valueOf(productDetail.getLastPrice()));

        Glide.with(getContext()).load(productDetail.getImage()).into(binding.ivDetail);

        binding.chipCredit.setText(productDetail.isCredit() ? "Con credito" : "Sin crédito");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}