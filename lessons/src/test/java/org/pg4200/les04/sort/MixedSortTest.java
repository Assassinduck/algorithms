package org.pg4200.les04.sort;

import org.pg4200.les03.sort.MySort;
import org.pg4200.les03.sort.SortTestTemplate;

public class MixedSortTest extends SortTestTemplate {

    @Override
    protected MySort getInstance() {
        return new OptimizedMergeSort();
    }
}
