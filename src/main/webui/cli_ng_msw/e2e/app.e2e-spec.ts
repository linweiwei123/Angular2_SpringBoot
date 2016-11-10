import { CliNgMswPage } from './app.po';

describe('cli-ng-msw App', function() {
  let page: CliNgMswPage;

  beforeEach(() => {
    page = new CliNgMswPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
