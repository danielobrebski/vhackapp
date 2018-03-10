import {AfterViewInit, Component, OnInit} from '@angular/core';
import {ChartDataService} from './chart-data.service';
import {Chart} from 'chart.js';

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent implements OnInit, AfterViewInit {

  chart = []; // This will hold our chart info
  ngOnInit(): void {
  }

  constructor(private chartDataService: ChartDataService) {
  }

  ngAfterViewInit() {
    this.chartDataService.get()
      .subscribe(res => {
        const labels = res.map(r => r.label);
        const datas = res.map(r => r.data)
        this.chart = new Chart('canvas', {
          type: 'doughnut',
          data: {
            labels: labels,
            datasets: [
              {
                data: datas,
                backgroundColor: [
                  'rgba(255, 99, 132, 0.2)',
                  'rgba(54, 162, 235, 0.2)'],
                fill: true
              }
            ]
          }
        });
      });
  }
}
