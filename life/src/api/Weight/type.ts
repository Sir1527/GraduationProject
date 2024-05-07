export interface WeightEcharts {
    weight?: Array<string>;
    bmi?: Array<string>;
    time?: Array<string>;
}

export interface respWeightEcharts {
    code?: string;
    message?: string;
    data?: WeightEcharts;
}

export interface WeightAdd {
    userId?: string;
    weight?: string;
    bmi?: string;
}