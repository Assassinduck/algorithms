package org.pg4200.ex08;

import org.pg4200.les06.set.MySetHashMap;
import org.pg4200.les08.stream.MyStream;
import org.pg4200.les08.stream.MyStreamCollectionList;
import org.pg4200.les08.stream.MyStreamSupport;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class AnotherStreamSupport {

    public static <T, C extends Iterable<T>> AnotherStream<T> createStream(C collection) {
        return new Pipeline<T, T, T>(collection.iterator());
    }

    protected static abstract class ChainedReference<IN, OUT> implements Consumer<IN> {

        protected final Consumer<OUT> downstream;

        public ChainedReference(Consumer<OUT> downstream) {
            this.downstream = Objects.requireNonNull(downstream);
        }
    }

    protected static class Pipeline<IN, OUT, T> implements AnotherStream<OUT> {

        private final Iterator<T> iterator;
        private final int depth;
        protected final Pipeline previousStage;

        protected Pipeline(Iterator<T> iterator) {
            this.iterator = iterator;
            this.depth = 0;
            this.previousStage = null;
        }

        protected Pipeline(Pipeline previousStage) {
            this.iterator = previousStage.iterator;
            this.previousStage = previousStage;
            this.depth = previousStage.depth + 1;
        }


        protected ChainedReference<IN, OUT> chainConsumerToCurrentPipe(Consumer<OUT> consumer) {
            throw new IllegalStateException();
        }

        protected Consumer<T> chainAllConsumersInThePipeline(Consumer<OUT> consumer) {
            Objects.requireNonNull(consumer);

            Pipeline p = this;

            while (p.depth > 0) {
                consumer = p.chainConsumerToCurrentPipe(consumer);
                p = p.previousStage;
            }

            return (Consumer<T>) consumer;


        }


        @Override
        public int count() {
            int[] counter = {0};
            Consumer<OUT> collectingConsumer = new Consumer<OUT>() {
                @Override
                public void accept(OUT out) {
                    counter[0]++;
                }
            };

            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);

            while (iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);
            }
            return counter[0];
        }


        @Override
        public String joinToString(String separator) {

            StringJoiner stringJoiner = new StringJoiner(separator);


            Consumer<OUT> collectingConsumer = new Consumer<OUT>() {
                @Override
                public void accept(OUT out) {
                    if (out != null) {
                        stringJoiner.add(out.toString());
                    } else {
                        stringJoiner.add("");
                    }
                }
            };

            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);


            while (iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);
            }
            return stringJoiner.toString();
        }

        @Override
        public boolean any(Predicate<OUT> predicate) {

            if (predicate == null) {
                return false;
            }

            boolean[] anyIsTrue = {false};

            Consumer<OUT> collectingConsumer = new Consumer<OUT>() {
                @Override
                public void accept(OUT out) {

                    anyIsTrue[0] = predicate.test(out);
                    ;
                }
            };

            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);


            while (iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);

                if (anyIsTrue[0]) {
                    return true;
                }
            }


            return false;
        }

        @Override
        public Optional<OUT> reduce(BinaryOperator<OUT> accumulator) {


            Boolean[] foundAny = {false};
            OUT[] result = (OUT[]) new Object[]{null};


            Consumer<OUT> collectingConsumer = new Consumer<OUT>() {
                @Override
                public void accept(OUT out) {
                    if (!foundAny[0]) {
                        foundAny[0] = true;
                        result[0] = out;
                    } else {
                        result[0] = accumulator.apply(result[0], out);
                    }

                }
            };

            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);


            while (iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);

            }


            return foundAny[0] ? Optional.of(result[0]) : Optional.empty();
        }

        @Override
        public AnotherStream<OUT> distinct() {

            return new Pipeline<OUT, OUT, T>(this) {
                @Override
                public ChainedReference<OUT, OUT> chainConsumerToCurrentPipe(Consumer<OUT> consumer) {
                    return new ChainedReference<OUT, OUT>(consumer) {

                        private final MySetHashMap<OUT> setHashMap = new MySetHashMap<>();

                        @Override
                        public void accept(OUT out) {
                            if (!setHashMap.isPresent(out)) {
                                setHashMap.add(out);
                                downstream.accept(out);
                            }

                        }
                    };
                }
            };
        }





        @Override
        public AnotherStream<OUT> skip(int n) {

            return new Pipeline<OUT, OUT, T>(this) {
                @Override
                public ChainedReference<OUT, OUT> chainConsumerToCurrentPipe(Consumer<OUT> consumer) {

                    return new ChainedReference<OUT, OUT>(consumer) {


                        private int skipped = 0;
                        private final int skip = n;

                        @Override
                        public void accept(OUT out) {
                            if (skipped < skip) {
                                skipped++;
                            } else {
                                downstream.accept(out);
                            }
                        }


                    };
                }
            };
        }


        @Override
        public AnotherStream<OUT> sorted() {

            List<OUT> list = new ArrayList<>();
            Consumer<OUT> collectingConsumer = list::add;

            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);

            while (iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);
            }

            list.sort((a, b) -> ((Comparable) a).compareTo(b));

            AnotherStreamList<OUT> anotherStreamList = new AnotherStreamList<>();
            for (OUT value : list) {
                anotherStreamList.add(value);
            }

            return anotherStreamList.stream();

        };
    }


}