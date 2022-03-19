package factory.splits;

import entity.split.EqualSplit;
import entity.split.Split;
import entity.split.SplitRequest;
import exception.InvalidSplitRequestException;
import validator.SplitsRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitsGenerator implements SplitsGenerator {

    @Override
    public List<Split> createSplits(SplitRequest splitRequest) throws InvalidSplitRequestException {
        SplitsRequestValidator.validateSplitRequest(splitRequest);

        List<Split> res = new ArrayList<>();
        for (int i = 0; i < splitRequest.getUsersInExpense().size(); i++) {
            res.add(new EqualSplit(splitRequest.getUsersInExpense().get(i)));
        }
        return res;
    }
}
